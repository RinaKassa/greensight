s = "".join(["my", "text" + "text2"])  # Noncompliant
s = ''.join(["my", "super", "text"])


# doubles guillemets
s = "my" + "text"  # Noncompliant
s += "my" + "text"  # Noncompliant

s = "0" * 12
s = 12 * "0"

# guillemet simple
s = 'my' + 'text'  # Noncompliant
s += 'my' + 'text'  # Noncompliant


s = "t"
s += "test"  # Noncompliant

# cas particuliers
s = "abcd" + "+".join(["ab", "cd"])
s = "abcd" + "0" * 12
s = 12 * "0" + "abcd"


# TODO: to improve this rule (see below)
# those lasts two are a bit hard to guest
# because python is a dynamically typed language,
# sonarqube isn't capable of guessing the type of variable (unless the user provided the type with typing extension),
# which mean we need to find out our self if the variable below is a (list of) string or something else

# mytext = "abcdef"
# s = "my" + mytext   # Noncompliant

words = ["this", "is", "my", "big", "list",
         "of", "totally", "safe", "strings"]

s = ""
# for substring in words:
#     s += substring  # Noncompliant

s = "".join(words)

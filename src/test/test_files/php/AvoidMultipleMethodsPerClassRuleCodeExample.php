<?php

  interface I {     // Noncompliant

  public function f1();
  public function f2();
  public function f3();
  public function f1();
    public function f2();
    public function f3();
    public function f1();
      public function f2();
      public function f3();
      public function f1();
        public function f2();
        public function f3();
        public function f1();
          public function f2();
          public function f3();
          public function f1();
            public function f2();
            public function f3();
            public function f1();
              public function f2();
              public function f3();
}

interface I {     // compliant

  public function f1();
  public function f2();
  public function f3();
  public function f1();
    public function f2();
    public function f3();
    public function f1();
      public function f2();
      public function f3();
      public function f1();
        public function f2();
        public function f3();
        public function f1();
          public function f2();
          public function f3();
          public function f1();
            public function f2();
            public function f3();
            public function f1();
              public function f2();
}


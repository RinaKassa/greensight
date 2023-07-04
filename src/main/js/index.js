import { createApp } from 'vue';
import { Quasar } from 'quasar';
import 'quasar/src/css/index.sass';
import GreensightApp from './GreensightApp.vue';

// You can access it at /project/extension/greensight/project
window.registerExtension('greensight/view', (options) => {
  // inject css in head only in production build
  if (process.env.NODE_ENV === 'production') {
    const css = document.createElement('link');
    css.setAttribute('rel', 'stylesheet');
    css.setAttribute('type', 'text/css');
    css.setAttribute('href', '/static/greensight/view.css');

    document.head.appendChild(css);
  }

  // options.el: Element DOM dans le quel vue.js doit injecter son contenu
  createApp(GreensightApp, options)
    .use(Quasar, {
      config: {
        brand: {
          primary: '#FF0000',
        },
      },
      plugins: {},
    })
    .mount(options.el);

  return function () {
    // any cleaning should happend here
  };
});

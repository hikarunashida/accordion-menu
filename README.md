# accordion-menu

### Run application:

```
lein clean
lein sass4clj once
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein sass4clj once
lein cljsbuild once min
```

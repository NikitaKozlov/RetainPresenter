# Presenter Retainer

Library for retaining Presenter on configuration change with minimal overhead. 
In case you don't know what Presenter is, check [MVP](https://en.wikipedia.org/wiki/Model–view–presenter).

If you are interesting how it works inside, please, check [this artcile](https://medium.com/@nikita.kozlov/retaining-presenter-on-configuration-change-with-minimal-overhead-e3d6d23ba851#.98nm8erc7).

## Example
You can find an example in `app` module. There you can find following cases:

1. *Single Activity*: Retaining presenter for activity without fragments.
2. *Activity with Fragment*: Retaining presenter for activity and fragment inside.
3. *Fragment Navigation*: Retaining presenter for navigation with fragments. When you replace fragment with new one, old presenter is destroyed.
4. *Nested Fragments inside ViewPager*: Activity contains fragment with nested fragments inside viewpager.


## How to start
1. Just extends `PresenterActivity` or `PresenterFragment`, depending on component you want to work with.
2. Override methods `onCreatePresenter()` and `getPresenterView()`
3. Enjoy.

__NB__ Activity which holds `PresenterFragment` __must__ extends `PresenterActivity`. If it doesn't need Presenter, just skip step 2.

## Presenter lifecycle.
1. `onAttachView(View)` Called to attach view to the Presenter.
2. `onDetachView()` Called to detach view from the Presenter.
3. `onDestroy()` Called when presenter is going to be destroyed.

## A few more facts.
1. In case you don't want to retain Presenter override `retainPresenter()` and return false.
2. If you want to reset Presenter state after configuration change, do that in `onPresenterRestored()` in Fragment or Activity.
3. __DO NOT__ override method `onRetainCustomNonConfigurationInstance()`. Use `onRetainCustomNonConfigurationObject()` instead. You can retrieve object later from `getLastCustomNonConfigurationObject()` method.

## Downloads

```groovy
dependencies {
    compile 'org.kaerdan.presenterretainer:presenterretainer:0.2.2'
}
```

## License

The MIT License (MIT)
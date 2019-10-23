package de.p72b.umi.github.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer

object Utils {
    const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ" //2014-02-04T14:38:36-08:00

    fun dispose(disposable: Disposable?) {
        when (disposable) {
            null -> return
            is DisposableContainer -> (disposable as CompositeDisposable).clear()
            else -> disposable.dispose()
        }
    }
}
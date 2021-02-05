package cn.clp.login

import android.util.Log

class Product2Consumer {
    val productMax: Int = 50
    private var currentProductCount = 0

    fun getProductCount(): Int {
        return currentProductCount
    }

    fun setProductCount(productCount: Int) {
        this.currentProductCount = productCount
    }

    fun product() {
        currentProductCount++
        Log.i("producter", "生产了" + currentProductCount)
    }

    fun consume() {
        currentProductCount--
        Log.i("producter", "消费了" + currentProductCount)
    }

    class Producer : Thread {
        private var model: Product2Consumer? = null

        constructor(model: Product2Consumer) {
            this.model = model
        }

        override fun run() {
            super.run()
            synchronized(this) {
                var count = model?.getProductCount()
                var max = model?.productMax
//                if (count != null && max != null) {
//                    if (count > max) {
//                    }
//                }
                count?.let { it ->
                    max?.let { it1 ->
                        if (it < it1) {
                            model?.product()
                        }else{
//                            wait()
                        }
                    }

                }
            }
        }
    }

    class Consumer : Thread {
        private var model: Product2Consumer? = null

        constructor(model: Product2Consumer) {
            this.model = model
        }

        override fun run() {
            super.run()
        }
    }
}
package cn.clp.login

import java.util.concurrent.atomic.AtomicReference

class SingleClass {
    companion object {
        @Volatile
        private var singleClass: SingleClass? = null
        private var INSTANCE = AtomicReference<SingleClass>()

        var NEW_INSTANCE_One = SingleClass()
        var NEW_INSTANCE_Two = createConstructor()
        var NEW_INSTANCE_Three = SingleClassHolder.NEW_INSTANCE
        var NEW_INSTANCE_Four = SingleClassEnum.NEW_INSTANCE.getInstance()
        var NEW_INSTANCE_Five = createConstructor2()

        private fun createConstructor2(): SingleClass {
            while (true) {
                var singleClass = INSTANCE.get()
                if (singleClass != null) {
                    return singleClass
                } else {
                    singleClass = SingleClass()
                    if (INSTANCE.compareAndSet(null, singleClass))
                        return singleClass
                }
            }
        }

        private fun createConstructor(): SingleClass? {
            if (singleClass == null) {
                synchronized(SingleClass::javaClass) {
                    if (singleClass == null)
                        return SingleClass()
                }
            }
            return singleClass
        }
    }

    private constructor()

    class SingleClassHolder {
        companion object {
            val NEW_INSTANCE = SingleClass()
        }
    }

    enum class SingleClassEnum {
        NEW_INSTANCE;

        fun getInstance(): SingleClass? {
            return SingleClass()
        }
    }
}

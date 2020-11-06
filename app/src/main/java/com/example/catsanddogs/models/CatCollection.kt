package com.example.catsanddogs.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatCollection(
    val cats: List<Cat>
) : Parcelable {
    companion object {
        //generating cats, and maybe dogs too ¯\_(ツ)_/¯
        fun generateCats1(): CatCollection {
            val cats = listOf(
                Cat("https://images.unsplash.com/photo-1545315171-cc80c905c252?ixlib=rb-1.2.1&auto=format&fit=crop&w=967&q=80"),
                Cat("https://images.unsplash.com/photo-1601758065893-25c11bfa69b5?ixlib=rb-1.2.1&auto=format&fit=crop&w=1958&q=80"),
                Cat("https://images.unsplash.com/photo-1564000689425-2f3898b441ad?ixlib=rb-1.2.1&auto=format&fit=crop&w=658&q=80"),
                Cat("https://images.unsplash.com/photo-1496284777878-ce2e3e4dd028?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"),
                Cat("https://images.unsplash.com/photo-1450778869180-41d0601e046e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1450&q=80")
            )
            return CatCollection(cats)
        }

        fun generateCats2(): CatCollection {
            val cats = listOf(
                Cat("https://images.unsplash.com/photo-1565715367074-4497ee5ae532?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                Cat("https://images.unsplash.com/photo-1542296935124-75ae8a4e6329?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                Cat("https://images.unsplash.com/photo-1491833485966-73cfb9ccea53?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                Cat("https://images.unsplash.com/photo-1496284777878-ce2e3e4dd028?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"),
                Cat("https://images.unsplash.com/photo-1450778869180-41d0601e046e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1450&q=80")
            )
            return CatCollection(cats)
        }

        fun generateCats3(): CatCollection {
            val cats = listOf(
                Cat("https://images.unsplash.com/photo-1473778841389-c66cb406c21e?ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
                Cat("https://images.unsplash.com/photo-1414638298765-18200405ba2f?ixlib=rb-1.2.1&auto=format&fit=crop&w=967&q=80"),
                Cat("https://images.unsplash.com/photo-1564000689425-2f3898b441ad?ixlib=rb-1.2.1&auto=format&fit=crop&w=658&q=80"),
                Cat("https://images.unsplash.com/photo-1496284777878-ce2e3e4dd028?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"),
                Cat("https://images.unsplash.com/photo-1460572894071-bde5697f7197?ixlib=rb-1.2.1&auto=format&fit=crop&w=1353&q=80")
            )
            return CatCollection(cats)
        }

        fun generateCats4(): CatCollection {
            val cats = listOf(
                Cat("https://images.unsplash.com/photo-1456677698485-dceeec22c7fc?ixlib=rb-1.2.1&auto=format&fit=crop&w=1347&q=80"),
                Cat("https://images.unsplash.com/photo-1601758065893-25c11bfa69b5?ixlib=rb-1.2.1&auto=format&fit=crop&w=1958&q=80"),
                Cat("https://images.unsplash.com/photo-1535123268188-3276dc455e77?ixlib=rb-1.2.1&auto=format&fit=crop&w=632&q=80"),
                Cat("https://images.unsplash.com/photo-1507568237455-03228e5ddb7e?ixlib=rb-1.2.1&auto=format&fit=crop&w=946&q=80"),
                Cat("https://images.unsplash.com/photo-1450778869180-41d0601e046e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1450&q=80")
            )
            return CatCollection(cats)
        }

        fun generateCats5(): CatCollection {
            val cats = listOf(
                Cat("https://images.unsplash.com/photo-1513839418289-9e4ef6ce7160?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
                Cat("https://images.unsplash.com/photo-1585689573260-d68cfdf08dd4?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
                Cat("https://images.unsplash.com/photo-1564000689425-2f3898b441ad?ixlib=rb-1.2.1&auto=format&fit=crop&w=658&q=80"),
                Cat("https://images.unsplash.com/photo-1523863745117-a610a34eb231?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
                Cat("https://images.unsplash.com/photo-1591960975465-c0f8587ab835?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
            )
            return CatCollection(cats)
        }
    }
}
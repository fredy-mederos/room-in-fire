package com.github.fredy_mederos.room_in_fire

/**
 * Created by @Fredy
 */


import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by @Fredy
 */
abstract class RoomInFireManager{

    /**
     * @return The current firebaseDatabase child name
     */
    abstract fun CHILD_NAME(): String

    /**
     * The current firebaseDatabase child event listener
     */
    abstract val childEventListener: ChildEventListener

    /**
     * The current child firebaseDatabase
     */
    val fireDataBaseRef: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.child(CHILD_NAME())
    }

    fun syncOn() {
        //todo include a rule to filter by company
        fireDataBaseRef/*.equalsTo()*/.addChildEventListener(childEventListener)
    }

    fun syncOff() {
        fireDataBaseRef.removeEventListener(childEventListener)
    }
}
/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelabs.state.todo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// These are required for mutableStatoOf() to work
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TodoViewModel : ViewModel() {

    // When hoisting state, there are three rules to help you figure out where it should go
    // 1. State should be hoisted to at least the lowest common parent of all composables that use the state (or read)
    // 2. State should be hoisted to at least the highest level it may be changed (or modified)
    // 3. If two states change in response to the same events they should be hoisted together

    // We can use state inside ViewModel, instead of LiveData.
    // But if this ViewModel was also used by the View system,
    // it would be better to continue using LiveData.
    // Application state that's used outside of Compose should not use State<T> to hold the state.
    var todoItems: List<TodoItem> by mutableStateOf(listOf())
        private set

    // Whenever a composable calls currentEditItem,
    // it will observe changes to both todoItems and currentEditPosition.
    // If either change, the composable will call the getter again to get the new value.
    val currentEditItem: TodoItem?
        get() = todoItems.getOrNull(currentEditPosition)

    // private state
    private var currentEditPosition by mutableStateOf(-1)

    // event: addItem
    fun addItem(item: TodoItem) {
        todoItems = todoItems + listOf(item)
    }

    // event: removeItem
    fun removeItem(item: TodoItem) {
        // toMutableList makes a mutable copy of the list we can edit, then
        // assign the new list to todoItems (which is still an immutable list)
        todoItems = todoItems.toMutableList().also {
            it.remove(item)
        }

        onEditDone() // don't keep the editor open when removing items
    }

    fun onEditItemSelected(item: TodoItem) {
        currentEditPosition = todoItems.indexOf(item)
    }

    fun onEditDone() {
        currentEditPosition = -1
    }

    fun onEditItemChange(item: TodoItem) {
        val currentItem = requireNotNull(currentEditItem)
        require(currentItem.id == item.id) {
            "You can only change an item with the same id as currentEditItem"
        }

        todoItems = todoItems.toMutableList().also {
            it[currentEditPosition] = item
        }
    }
}

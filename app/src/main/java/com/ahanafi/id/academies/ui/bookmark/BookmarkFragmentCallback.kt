package com.ahanafi.id.academies.ui.bookmark

import com.ahanafi.id.academies.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}

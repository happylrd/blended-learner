from django.contrib import admin

from .models import StudentActivity


class StudentActivityAdmin(admin.ModelAdmin):
    list_display = ('student', 'activity', 'has_finished', 'add_time',)
    list_filter = ('student', 'activity', 'has_finished',)


admin.site.register(StudentActivity, StudentActivityAdmin)

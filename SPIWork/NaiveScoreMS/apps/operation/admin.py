from django.contrib import admin

from .models import StudentActivity


class StudentActivityAdmin(admin.ModelAdmin):
    list_display = ('student', 'activity', 'add_time',)


admin.site.register(StudentActivity, StudentActivityAdmin)

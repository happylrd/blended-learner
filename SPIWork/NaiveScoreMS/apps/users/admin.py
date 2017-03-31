from django.contrib import admin

from .models import StudentProfile


class StudentProfileAdmin(admin.ModelAdmin):
    list_display = ('username', 'realname', 'mobile', 'school', 'major',)


admin.site.register(StudentProfile, StudentProfileAdmin)

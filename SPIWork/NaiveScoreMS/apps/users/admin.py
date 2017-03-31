from django.contrib import admin

from .models import Student, Teacher, Administrator


class StudentAdmin(admin.ModelAdmin):
    list_display = ('username', 'realname', 'school', 'major',)


class TeacherAdmin(admin.ModelAdmin):
    list_display = ('username', 'realname', 'school', 'gender',)


class AdministratorAdmin(admin.ModelAdmin):
    list_display = ('username', 'realname', 'gender', 'birthday',)


admin.site.register(Student, StudentAdmin)
admin.site.register(Teacher, TeacherAdmin)
admin.site.register(Administrator, AdministratorAdmin)

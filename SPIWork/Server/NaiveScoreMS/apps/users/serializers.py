from rest_framework import serializers

from .models import Student, Teacher, Administrator


class StudentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Student
        fields = ('id', 'username', 'password', 'realname', 'mobile', 'school', 'major',
                  'gender', 'birthday', 'permission_type', 'add_time')


class TeacherSerializer(serializers.ModelSerializer):
    class Meta:
        model = Teacher
        fields = ('id', 'username', 'password', 'realname', 'mobile', 'school',
                  'gender', 'birthday', 'add_time')


class AdministratorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Administrator
        fields = ('id', 'username', 'password', 'last_login', 'realname', 'email',
                  'mobile', 'gender', 'birthday', 'add_time')

from rest_framework import serializers

from .models import Student, Administrator


class StudentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Student
        fields = ('id', 'username', 'password', 'realname', 'mobile', 'school', 'major',
                  'gender', 'birthday', 'add_time')


class AdministratorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Administrator
        fields = ('id', 'username', 'password', 'last_login', 'realname', 'email',
                  'mobile', 'gender', 'birthday', 'add_time')

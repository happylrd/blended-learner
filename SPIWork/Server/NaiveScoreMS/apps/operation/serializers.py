from rest_framework import serializers

from .models import StudentActivity


class StudentActivitySerializer(serializers.ModelSerializer):
    class Meta:
        model = StudentActivity
        fields = ('id', 'student', 'activity', 'has_finished', 'add_time')

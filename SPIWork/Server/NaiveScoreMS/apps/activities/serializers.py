from rest_framework import serializers

from .models import Activity


class ActivitySerializer(serializers.ModelSerializer):
    class Meta:
        model = Activity
        fields = ('id', 'name', 'score', 'desc', 'has_passed',
                  'start_time', 'end_time', 'add_time')

# coding=utf-8
from __future__ import unicode_literals
from datetime import datetime

from django.db import models

from users.models import StudentProfile
from activities.models import Activity


class StudentActivity(models.Model):
    student = models.ForeignKey(StudentProfile, verbose_name='学生')
    activity = models.ForeignKey(Activity, verbose_name='活动')
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '学生活动'
        verbose_name_plural = verbose_name

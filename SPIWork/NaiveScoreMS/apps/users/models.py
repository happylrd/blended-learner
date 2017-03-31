# coding=utf-8
from __future__ import unicode_literals

from django.db import models
from django.contrib.auth.models import AbstractUser


class StudentProfile(AbstractUser):
    realname = models.CharField(verbose_name='姓名', max_length=10)
    mobile = models.CharField(verbose_name='手机号', max_length=11, null=True, blank=True)
    school = models.CharField(verbose_name='学院', max_length=20)
    major = models.CharField(verbose_name='专业', max_length=30)
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female')
    birthday = models.DateField(verbose_name='生日', null=True, blank=True)

    class Meta:
        verbose_name = '学生信息'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.username

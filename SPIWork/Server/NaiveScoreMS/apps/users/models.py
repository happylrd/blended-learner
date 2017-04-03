# coding=utf-8
from __future__ import unicode_literals
from datetime import datetime

from django.db import models
from django.contrib.auth.models import AbstractUser


class Student(models.Model):
    username = models.CharField(max_length=30, unique=True, verbose_name='用户名')
    password = models.CharField(max_length=128, verbose_name='密码')
    realname = models.CharField(max_length=10, verbose_name='姓名')
    mobile = models.CharField(max_length=11, null=True, blank=True, verbose_name='手机号')
    school = models.CharField(max_length=20, verbose_name='学院')
    major = models.CharField(max_length=30, verbose_name='专业')
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female',
                              verbose_name='性别')
    birthday = models.DateField(null=True, blank=True, verbose_name='生日')
    permission_type = models.IntegerField(choices=((0, '一般'), (1, '添加'), (2, '检查')), default=0, verbose_name='权限类型')
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '学生信息'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.username


class Teacher(models.Model):
    username = models.CharField(max_length=30, unique=True, verbose_name='用户名')
    password = models.CharField(max_length=128, verbose_name='密码')
    realname = models.CharField(max_length=10, verbose_name='姓名')
    mobile = models.CharField(max_length=11, null=True, blank=True, verbose_name='手机号')
    school = models.CharField(max_length=20, verbose_name='学院')
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female',
                              verbose_name='性别')
    birthday = models.DateField(null=True, blank=True, verbose_name='生日')
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '教师信息'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.username


class Administrator(AbstractUser):
    realname = models.CharField(max_length=10, verbose_name='姓名')
    mobile = models.CharField(max_length=11, null=True, blank=True, verbose_name='手机号')
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female',
                              verbose_name='性别')
    birthday = models.DateField(null=True, blank=True, verbose_name='生日')
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '管理员信息'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.username

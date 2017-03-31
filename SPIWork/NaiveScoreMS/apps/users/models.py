# coding=utf-8
from __future__ import unicode_literals
from datetime import datetime

from django.db import models
from django.contrib.auth.models import AbstractUser


class Student(models.Model):
    username = models.CharField(max_length=30, verbose_name='用户名')
    password = models.CharField(max_length=128, verbose_name='密码')
    realname = models.CharField(verbose_name='姓名', max_length=10)
    mobile = models.CharField(verbose_name='手机号', max_length=11, null=True, blank=True)
    school = models.CharField(verbose_name='学院', max_length=20)
    major = models.CharField(verbose_name='专业', max_length=30)
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female')
    birthday = models.DateField(verbose_name='生日', null=True, blank=True)
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '学生信息'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.username


class Teacher(models.Model):
    username = models.CharField(max_length=30, verbose_name='用户名')
    password = models.CharField(max_length=128, verbose_name='密码')
    realname = models.CharField(max_length=10, verbose_name='姓名')
    mobile = models.CharField(max_length=11, null=True, blank=True, verbose_name='手机号')
    school = models.CharField(max_length=20, verbose_name='学院')
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female')
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
    gender = models.CharField(max_length=6, choices=(('male', '男'), ('female', '女')), default='female')
    birthday = models.DateField(null=True, blank=True, verbose_name='生日')
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '管理员信息'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.username

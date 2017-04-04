# coding=utf-8
from __future__ import unicode_literals
from datetime import datetime

from django.db import models


class Activity(models.Model):
    name = models.CharField(max_length=50, verbose_name='活动名')
    score = models.DecimalField(max_digits=5, decimal_places=2, verbose_name='分数')
    desc = models.CharField(max_length=300, verbose_name='活动描述')
    state = models.IntegerField(choices=((0, '待审核'), (1, '审核通过')), default=0, verbose_name='活动状态')
    start_time = models.DateTimeField(verbose_name='开始时间')
    end_time = models.DateTimeField(verbose_name='结束时间')
    add_time = models.DateTimeField(default=datetime.now, verbose_name='添加时间')

    class Meta:
        verbose_name = '活动'
        verbose_name_plural = verbose_name

    def __unicode__(self):
        return self.name

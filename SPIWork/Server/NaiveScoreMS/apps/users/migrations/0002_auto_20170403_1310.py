# -*- coding: utf-8 -*-
# Generated by Django 1.9.8 on 2017-04-03 13:10
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='student',
            name='permission_type',
            field=models.IntegerField(choices=[(0, '\u4e00\u822c'), (1, '\u6dfb\u52a0'), (2, '\u68c0\u67e5')], default=0, verbose_name='\u6743\u9650\u7c7b\u578b'),
        ),
        migrations.AlterField(
            model_name='administrator',
            name='gender',
            field=models.CharField(choices=[('male', '\u7537'), ('female', '\u5973')], default='female', max_length=6, verbose_name='\u6027\u522b'),
        ),
        migrations.AlterField(
            model_name='student',
            name='gender',
            field=models.CharField(choices=[('male', '\u7537'), ('female', '\u5973')], default='female', max_length=6, verbose_name='\u6027\u522b'),
        ),
        migrations.AlterField(
            model_name='student',
            name='username',
            field=models.CharField(max_length=30, unique=True, verbose_name='\u7528\u6237\u540d'),
        ),
        migrations.AlterField(
            model_name='teacher',
            name='gender',
            field=models.CharField(choices=[('male', '\u7537'), ('female', '\u5973')], default='female', max_length=6, verbose_name='\u6027\u522b'),
        ),
        migrations.AlterField(
            model_name='teacher',
            name='username',
            field=models.CharField(max_length=30, unique=True, verbose_name='\u7528\u6237\u540d'),
        ),
    ]

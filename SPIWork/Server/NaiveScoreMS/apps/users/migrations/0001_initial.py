# -*- coding: utf-8 -*-
# Generated by Django 1.9.8 on 2017-03-31 07:39
from __future__ import unicode_literals

import datetime
import django.contrib.auth.models
import django.core.validators
from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('auth', '0007_alter_validators_add_error_messages'),
    ]

    operations = [
        migrations.CreateModel(
            name='Administrator',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('password', models.CharField(max_length=128, verbose_name='password')),
                ('last_login', models.DateTimeField(blank=True, null=True, verbose_name='last login')),
                ('is_superuser', models.BooleanField(default=False, help_text='Designates that this user has all permissions without explicitly assigning them.', verbose_name='superuser status')),
                ('username', models.CharField(error_messages={'unique': 'A user with that username already exists.'}, help_text='Required. 30 characters or fewer. Letters, digits and @/./+/-/_ only.', max_length=30, unique=True, validators=[django.core.validators.RegexValidator('^[\\w.@+-]+$', 'Enter a valid username. This value may contain only letters, numbers and @/./+/-/_ characters.')], verbose_name='username')),
                ('first_name', models.CharField(blank=True, max_length=30, verbose_name='first name')),
                ('last_name', models.CharField(blank=True, max_length=30, verbose_name='last name')),
                ('email', models.EmailField(blank=True, max_length=254, verbose_name='email address')),
                ('is_staff', models.BooleanField(default=False, help_text='Designates whether the user can log into this admin site.', verbose_name='staff status')),
                ('is_active', models.BooleanField(default=True, help_text='Designates whether this user should be treated as active. Unselect this instead of deleting accounts.', verbose_name='active')),
                ('date_joined', models.DateTimeField(default=django.utils.timezone.now, verbose_name='date joined')),
                ('realname', models.CharField(max_length=10, verbose_name='\u59d3\u540d')),
                ('mobile', models.CharField(blank=True, max_length=11, null=True, verbose_name='\u624b\u673a\u53f7')),
                ('gender', models.CharField(choices=[('male', '\u7537'), ('female', '\u5973')], default='female', max_length=6)),
                ('birthday', models.DateField(blank=True, null=True, verbose_name='\u751f\u65e5')),
                ('add_time', models.DateTimeField(default=datetime.datetime.now, verbose_name='\u6dfb\u52a0\u65f6\u95f4')),
                ('groups', models.ManyToManyField(blank=True, help_text='The groups this user belongs to. A user will get all permissions granted to each of their groups.', related_name='user_set', related_query_name='user', to='auth.Group', verbose_name='groups')),
                ('user_permissions', models.ManyToManyField(blank=True, help_text='Specific permissions for this user.', related_name='user_set', related_query_name='user', to='auth.Permission', verbose_name='user permissions')),
            ],
            options={
                'verbose_name': '\u7ba1\u7406\u5458\u4fe1\u606f',
                'verbose_name_plural': '\u7ba1\u7406\u5458\u4fe1\u606f',
            },
            managers=[
                ('objects', django.contrib.auth.models.UserManager()),
            ],
        ),
        migrations.CreateModel(
            name='Student',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=30, verbose_name='\u7528\u6237\u540d')),
                ('password', models.CharField(max_length=128, verbose_name='\u5bc6\u7801')),
                ('realname', models.CharField(max_length=10, verbose_name='\u59d3\u540d')),
                ('mobile', models.CharField(blank=True, max_length=11, null=True, verbose_name='\u624b\u673a\u53f7')),
                ('school', models.CharField(max_length=20, verbose_name='\u5b66\u9662')),
                ('major', models.CharField(max_length=30, verbose_name='\u4e13\u4e1a')),
                ('gender', models.CharField(choices=[('male', '\u7537'), ('female', '\u5973')], default='female', max_length=6)),
                ('birthday', models.DateField(blank=True, null=True, verbose_name='\u751f\u65e5')),
                ('add_time', models.DateTimeField(default=datetime.datetime.now, verbose_name='\u6dfb\u52a0\u65f6\u95f4')),
            ],
            options={
                'verbose_name': '\u5b66\u751f\u4fe1\u606f',
                'verbose_name_plural': '\u5b66\u751f\u4fe1\u606f',
            },
        ),
        migrations.CreateModel(
            name='Teacher',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=30, verbose_name='\u7528\u6237\u540d')),
                ('password', models.CharField(max_length=128, verbose_name='\u5bc6\u7801')),
                ('realname', models.CharField(max_length=10, verbose_name='\u59d3\u540d')),
                ('mobile', models.CharField(blank=True, max_length=11, null=True, verbose_name='\u624b\u673a\u53f7')),
                ('school', models.CharField(max_length=20, verbose_name='\u5b66\u9662')),
                ('gender', models.CharField(choices=[('male', '\u7537'), ('female', '\u5973')], default='female', max_length=6)),
                ('birthday', models.DateField(blank=True, null=True, verbose_name='\u751f\u65e5')),
                ('add_time', models.DateTimeField(default=datetime.datetime.now, verbose_name='\u6dfb\u52a0\u65f6\u95f4')),
            ],
            options={
                'verbose_name': '\u6559\u5e08\u4fe1\u606f',
                'verbose_name_plural': '\u6559\u5e08\u4fe1\u606f',
            },
        ),
    ]

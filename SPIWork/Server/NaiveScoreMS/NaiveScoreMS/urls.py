"""NaiveScoreMS URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.9/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url, include
from django.contrib import admin

from users.views import StudentListView, StudentDetailView, TeacherListView, TeacherDetailView, AdministratorListView
from activities.views import ActivityListView, ActivityDetailView
from operation.views import StudentActivityListView, StudentActivityDetailView, get_total_score

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^api-auth/', include('rest_framework.urls',
                               namespace='rest_framework')),

    # API urls
    url(r'^users/students/$',
        StudentListView.as_view(), name='student-list'),
    url(r'^users/students/(?P<username>.*)/$',
        StudentDetailView.as_view(), name='student-detail'),
    url(r'^users/teachers/$',
        TeacherListView.as_view(), name='teacher-list'),
    url(r'^users/teachers/(?P<username>.*)/$',
        TeacherDetailView.as_view(), name='teacher-detail'),
    url(r'^users/administrators/$',
        AdministratorListView.as_view(), name='administrator-list'),

    url(r'^activities/$',
        ActivityListView.as_view(), name='activity-list'),
    url(r'^activities/(?P<pk>[0-9]+)/$',
        ActivityDetailView.as_view(), name='activity-detail'),

    url(r'^studentactivities/$',
        StudentActivityListView.as_view(), name='student-activity-list'),
    url(r'^studentactivities/(?P<pk>[0-9]+)/$',
        StudentActivityDetailView.as_view(), name='student-activity-detail'),

    url(r'^score/students/(?P<username>.*)/sum/$',
        get_total_score, name='get_total_score'),
]

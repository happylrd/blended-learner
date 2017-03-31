from django.contrib import admin

from .models import Activity


class ActivityAdmin(admin.ModelAdmin):
    list_display = ('name', 'desc', 'score', 'start_time', 'end_time',)


admin.site.register(Activity, ActivityAdmin)

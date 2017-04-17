from django.http import JsonResponse
from django.db.models import Sum
from rest_framework import generics

from .models import StudentActivity
from activities.models import Activity
from .serializers import StudentActivitySerializer


class StudentActivityListView(generics.ListCreateAPIView):
    queryset = StudentActivity.objects.all()
    serializer_class = StudentActivitySerializer


class StudentActivityDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset = StudentActivity.objects.all()
    serializer_class = StudentActivitySerializer


# TODO:will be improved later
def get_total_score(request, username):
    result = Activity.objects.filter(studentactivity__student__username=username, studentactivity__has_finished=True,
                                     has_passed=True)
    # print result

    if result:
        total_score = result.aggregate(Sum('score'))
        myActList = dict({'activities': list(result.values())}, **total_score)
        # print myActList
        return JsonResponse(myActList)
    else:
        empty_data = {
            'activities': [],
            'score__sum': '-1'
        }
        return JsonResponse(empty_data)

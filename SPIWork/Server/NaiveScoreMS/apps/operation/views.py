from rest_framework import generics

from .models import StudentActivity
from .serializers import StudentActivitySerializer


class StudentActivityListView(generics.ListCreateAPIView):
    queryset = StudentActivity.objects.all()
    serializer_class = StudentActivitySerializer


class StudentActivityDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset = StudentActivity.objects.all()
    serializer_class = StudentActivitySerializer

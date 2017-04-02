from rest_framework import generics

from .models import Student, Administrator
from .serializers import StudentSerializer, AdministratorSerializer


class StudentListView(generics.ListCreateAPIView):
    queryset = Student.objects.all()
    serializer_class = StudentSerializer


class StudentDetailView(generics.RetrieveUpdateDestroyAPIView):
    queryset = Student.objects.all()
    serializer_class = StudentSerializer
    # Set `lookup_field` to `username` instead of `pk`
    lookup_field = 'username'


class AdministratorListView(generics.ListCreateAPIView):
    queryset = Administrator.objects.all()
    serializer_class = AdministratorSerializer

# SPIWork

> just a little homework for learning SPI(Software Process Improvement).

项目采用了 **前后端分离** 架构。
后端只专注于提供API，Android端只专注于与API进行交互。

Android端的页面分为
  - 原生页面
  - WebView 包裹 django admin

### Powered by

- API Server
  - django
    - django-rest-framework
    - django-material
- Android
  - retrofit
  - gson
  - glide
  - some ui components

#### Partial Development Env

- OS
  - Win 10
- IDE
  - PyCharm
  - Android Studio
- Env
  - python 2.7.13
  - django 1.9.8
    - django-rest-framework
    - django-material
  - Some Tools
    - [virtualenv](https://github.com/pypa/virtualenv)
    - [virtualenvwrapper-win](https://github.com/davidmarble/virtualenvwrapper-win)
- API Test Tool
  - Postman

В powershell

1. Проверка
    ````
    javadoc -version
    ````
2. Найдите, где установлен javadoc:
    ````
    where javadoc
    ````
   Или (если where не работает):
    ````
    Get-ChildItem -Path "C:\Program Files\Java" -Recurse -Filter "javadoc.exe" -ErrorAction SilentlyContinue
    ````
   Должно выдать
    ````
    Каталог: C:\Program Files\Java\jdk-24\bin
    ````
3. Скопируйте путь к директории с javadoc.exe (например, C:\Program Files\Java\jdk-17.0.2\bin)
   и в консоли под админом
    ````
    [System.Environment]::SetEnvironmentVariable("PATH", "$env:PATH;C:\Program Files\Java\jdk-17.0.2\bin", "Machine")
    ````
4. После этого перезагружаем idea и проверяем
    ````
       javadoc -version
    ````
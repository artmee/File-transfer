# Передача файла по TCP с подсчётом скорости передачи данных
Протокол передачи произвольного файла с одного компьютера на другой:

1. Client: Отправка длины имени файла (4 байта)
2. Client: Отправка имени файла 
4. Server: Получение данных
7. Client: Отправка длины файла (4байта)
8. Client: Отправка всего файла
10. Server: Получение всего файла

# Передача файла по TCP с подсчётом скорости передачи данных
Протокол передачи произвольного файла с одного компьютера на другой:

1. Client: Отправка длины имени файла (4 байта)
2. Client: Отправка имени файла 
3. Client: Отправка контрольной суммы hashcode для имени (4 байта)
4. Server: Получение данных
5. Server: Сравнивание hashcode и отправка подтверждения (4 байта)
6. Client: Получение подвержжения
7. Client: Отправка длины файла (4байта)
8. Client: Отправка всего файла
9. Client: Отправка контрольной суммы для файла
10. Server: Получение всего файла
11. Server: Сравнивание hashcode и отправка подтверждения (4 байта)

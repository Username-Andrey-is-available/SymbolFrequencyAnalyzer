# Проект "Частота символов"
Простое REST API для вычисления частоты встречи символов в заданной строке.

## Требования

- Java 11+
- Gradle (встроен в проект)

## Запуск

1. Клонируйте репозиторий: `git clone https://github.com/Username-Andrey-is-available/SymbolFrequencyAnalyzer.git`
2. Перейдите в каталог проекта: `cd ваш-репозиторий`
3. Запустите проект: `./gradlew bootRun` (или `./gradlew.bat bootRun` для Windows)

## Использование

Примеры использования API:

```bash
curl -X GET "http://localhost:8080/api/frequency?inputString=aaaaabcccc"

Формат входных параметров
"aaaaabcccc" (строка): Входная строка для вычисления частоты символов.

Формат выходных параметров
Результат вычисления частоты символов в формате JSON:
{
  "a": 5,
  "c": 4,
  "b": 1
}

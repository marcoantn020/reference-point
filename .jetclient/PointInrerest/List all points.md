```toml
name = 'List all points'
method = 'GET'
url = 'http://localhost:8080/points-of-interest'
sortWeight = 2000000
id = 'e889a017-788e-4f48-813f-6360cb90b622'

[[queryParams]]
key = 'page'
value = '0'
disabled = true

[body]
type = 'JSON'
raw = '''
{
  "name": "lanchonet",
  "x_axis": 25,
  "y_axis": 15,
}'''
```

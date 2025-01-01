```toml
name = 'near me'
method = 'GET'
url = 'http://localhost:8080/points-of-interest/near-me?x_axis=20&y_axis=10&distance=10'
sortWeight = 3000000
id = '1976f5b3-046e-43ca-9ec4-a3cbf97db04e'

[[queryParams]]
key = 'x_axis'
value = '20'

[[queryParams]]
key = 'y_axis'
value = '10'

[[queryParams]]
key = 'distance'
value = '10'

[body]
type = 'JSON'
raw = '''
{
  "name": "lanchonet",
  "x_axis": 25,
  "y_axis": 15,
}'''
```

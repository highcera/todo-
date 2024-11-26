import requests

# 메세지를 보냅니다.
def SendMessage(msg):
    try:
        TARGET_URL = 'https://notify-api.line.me/api/notify'
        TOKEN = '3DSvcMbLGxG9Ejp2bQGAolv3dDxIAj6WTQVYW562oXs'

        response = requests.post(
            TARGET_URL,
            headers={
                'Authorization': 'Bearer ' + TOKEN
            },
            data={
                'message': msg
            }
        )

    except Exception as ex:
        print(ex)
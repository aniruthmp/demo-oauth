## How to test?

1. First generate the token
    ```bash
    curl -s -X POST https://pivot-aparthasarathy.login.run.pcfbeta.io/oauth/token -H "Content-Type: application/x-www-form-urlencoded" -d "client_id=f17dfc29-7c0f-4e50-af2c-06a21b670fd0&client_secret=4ddded4b-3d76-4050-b992-aca956ca489f&grant_type=client_credentials" | jq -r .access_token
    ```
1. Ensure [jq](https://stedolan.github.io/jq/) is installed. if jq is not installed, remove `jq` from the above command
1. This can be done using [Postman](https://www.getpostman.com/) as below ![SCREENSHOT](/docs/postman.png)
1. Use the above token in invoking the endpoinsts


# Discord-hytale linker
<small>A simple and lightweight way to bridge your hytale and discord server</small>

## How to get started

1. Set up your hytale server following [this](https://support.hytale.com/hc/en-us/articles/45326769420827-Hytale-Server-Manual) guide

2. Download the mod from [here](https://github.com/Simon-Weij/Discord-Linker-Hytale/releases/download/Release/discord-linker-1.0.0.jar) (or the latest github release)

3. Add the mod to your server in the plugins folder

4. Restart your server

5. Put a secure token in the server.properties file. e.g token=secure_token_that_i_wont_leak, make sure this token doesn't get leaked.

6. Invite the discord bot to your server using [this link](https://discord.com/oauth2/authorize?client_id=1461459518427762739&permissions=2147552272&response_type=code&redirect_uri=https%3A%2F%2Fgithub.com%2FSimon-Weij%2FDiscord-Linker-Frontend&integration_type=0&scope=messages.read+bot+applications.commands)

7. Run /configure with the following arguments
- Channel -> the channel where messages will appear 
- Server ip -> the ip of your server
- Token -> The token you generated in step 5.

8. Run /start and enjoy :D
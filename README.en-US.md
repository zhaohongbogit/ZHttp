

# ZHttp
A project integrating okHttp, Volley, https, and ssl.

After Android was upgraded to version 6.0, the official httpClient underlying classes were removed, causing previous network requests to become unusable.

The officially recommended Volley and okHttp network libraries have gained high popularity. Each has its own advantages and disadvantages, and some developers have already integrated both.

Volley handles low-level processing well and can automatically adapt to connections across different Android versions. It uses ApacheHttpStack for Android 3.0 and above, and HttpURLConnection for Android 2.3 and below.

OkHttp handles the transport layer well, supports SPDY (which enables https), and automatically switches network environments for servers with multiple IP addresses.

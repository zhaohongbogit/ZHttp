# ZHttp
使用okHttp,Volley,https,ssl整合的项目

android升级到6.0之后，官方去掉了httpClient底层类，导游以前的网络请求无法使用。

官方推荐使用的Volley请求和okHttp请求网络呼声比较高，并且各自有各自的优缺点，有大神已经整合两项内容。

Volley对底层处理比较好，可以自动识别android各个版本的链接，Android3.0以上使用ApacheHttpStack访问，2.3及以下使用HttpURLConnection进行链接

而okHttp对传输层处理比较好，持SPDY（可以使用https），并且对多IP服务器自动进行网络环境切换

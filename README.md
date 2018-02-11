# EasyVolley

A library with a simple structure for sending requests and receiving responses to the server. <br/>
This new Wrapper library is from the Volley Library, which is much simpler to implement.

## Instalation ##
<br/>

### with jcenter ###
Add the dependency
```
	dependencies {
	        compile 'com.smrahmadi:EasyVolley:0.0.1'
	}
```


### with jitpack ###
Step 1. Add the JitPack repository to your build file<br/>
```	
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
```

Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.smrahmadi:EasyVolley:-SNAPSHOT'
	}
  
```
- - - -
## How To use  ##
its Very Easy
<br/><br/>
Step 1. Add the internet Permision to manifest<br/>

```
    <uses-permission android:name="android.permission.INTERNET"/>

```

<br/><br/>
Step 2. Create two ` ArrayList<String> ` for Keys and Values . If both are not an item, this means that a particular key and value is not supposed to be sent . <br/>
```

        ArrayList<String> keys= new ArrayList<String>();
        ArrayList<String> values= new ArrayList<String>();

```

<br/><br/>
Step 3. Send Requset with below Structure <br/>

```
        easyVolley.sendRequest(this, "Your_URL", keys, values, 1, new easyVolley.GetJson() {
            @Override
            public void onSuccess(String result) {
                // your Code is here


            }

            @Override
            public void onError(String result, int errCode) {
                // your code is here
            }
        });

```

#### notice :
The fifth input of the int-type function specifies which request to send.

If it is equal to `0` , it will be sent by `post` method and if it is `1` , the method is `get`

package com.tagenigma.example;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomActivityProxyObjectHelper {
    public static final String metaDataValue = "UnityPlayerActivityProxy";
    protected static final String TAG = "Prime31";
    private List<Class<?>> _proxyClasses = new ArrayList();
    private Activity _context;

    public CustomActivityProxyObjectHelper(Activity context) {
        this._context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        try {
            ApplicationInfo c = this._context.getPackageManager().getApplicationInfo(this._context.getPackageName(), 128);
            Bundle bundle = c.metaData;
            Iterator var5 = bundle.keySet().iterator();

            while(var5.hasNext()) {
                String m = (String)var5.next();

                try {
                    Object bundleValue = bundle.get(m);
                    if(bundleValue instanceof String) {
                        String value = (String)bundleValue;
                        if(value.equalsIgnoreCase("UnityPlayerActivityProxy")) {
                            try {
                                Class e = Class.forName(m);
                                this._proxyClasses.add(e);
                                Log.i("Prime31", "found Activity proxy class: " + e);
                            } catch (ClassNotFoundException var10) {
                                Log.e("Prime31", "no proxy class found for " + m);
                            }
                        }
                    }
                } catch (Exception var11) {
                    ;
                }
            }
        } catch (NameNotFoundException var12) {
            Log.i("Prime31", "Failed to load meta-data, NameNotFound: " + var12.getMessage());
        } catch (NullPointerException var13) {
            Log.e("Prime31", "Failed to load meta-data, NullPointer: " + var13.getMessage());
        }

        Iterator bundle1 = this._proxyClasses.iterator();

        while(bundle1.hasNext()) {
            Class c1 = (Class)bundle1.next();

            try {
                Method m1 = c1.getMethod("onCreate", new Class[]{Bundle.class});
                m1.invoke((Object)null, new Object[]{savedInstanceState});
            } catch (Exception var9) {
                ;
            }
        }

    }

    protected void onNewIntent(Intent intent) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod("onNewIntent", new Class[]{Intent.class});
                m.invoke((Object)null, new Object[]{intent});
            } catch (Exception var5) {
                ;
            }
        }

    }

    protected void onActivityResult(int request, int response, Intent data) {
        Iterator var5 = this._proxyClasses.iterator();

        while(var5.hasNext()) {
            Class c = (Class)var5.next();

            try {
                Method m = c.getMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class});
                m.invoke((Object)null, new Object[]{Integer.valueOf(request), Integer.valueOf(response), data});
            } catch (Exception var7) {
                ;
            }
        }

    }

    protected void invokeZeroParameterMethod(String method) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod(method, new Class[0]);
                m.invoke((Object)null, new Object[0]);
            } catch (Exception var5) {
                ;
            }
        }

    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod("onSaveInstanceState", new Class[]{Bundle.class});
                m.invoke((Object)null, new Object[]{savedInstanceState});
            } catch (Exception var5) {
                ;
            }
        }

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod("onRestoreInstanceState", new Class[]{Bundle.class});
                m.invoke((Object)null, new Object[]{savedInstanceState});
            } catch (Exception var5) {
                ;
            }
        }

    }

    public void onConfigurationChanged(Configuration newConfig) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod("onConfigurationChanged", new Class[]{Configuration.class});
                m.invoke((Object)null, new Object[]{newConfig});
            } catch (Exception var5) {
                ;
            }
        }

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod("onWindowFocusChanged", new Class[]{Boolean.TYPE});
                m.invoke((Object)null, new Object[]{Boolean.valueOf(hasFocus)});
            } catch (Exception var5) {
                ;
            }
        }

    }

    public void onKeyDown(int keyCode, KeyEvent event) {
        Iterator var4 = this._proxyClasses.iterator();

        while(var4.hasNext()) {
            Class c = (Class)var4.next();

            try {
                Method m = c.getMethod("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class});
                m.invoke((Object)null, new Object[]{Integer.valueOf(keyCode), event});
            } catch (Exception var6) {
                ;
            }
        }

    }

    public void onKeyUp(int keyCode, KeyEvent event) {
        Iterator var4 = this._proxyClasses.iterator();

        while(var4.hasNext()) {
            Class c = (Class)var4.next();

            try {
                Method m = c.getMethod("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class});
                m.invoke((Object)null, new Object[]{Integer.valueOf(keyCode), event});
            } catch (Exception var6) {
                ;
            }
        }

    }

    public void onTrimMemory(int level) {
        Iterator var3 = this._proxyClasses.iterator();

        while(var3.hasNext()) {
            Class c = (Class)var3.next();

            try {
                Method m = c.getMethod("onTrimMemory", new Class[]{Integer.TYPE});
                m.invoke((Object)null, new Object[]{Integer.valueOf(level)});
            } catch (Exception var5) {
                ;
            }
        }

    }
}

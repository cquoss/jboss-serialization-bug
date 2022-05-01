# jboss-serialization-bug
Repository showing the bug that appeared in jboss-serialization when running in jdk 8 update 322 while  marshalling Hashtable objects.

Problem as shows:

Debug Log Output running with jdk8u312:

```
C:\Users\cleme\java\jdks\jdk-8-312\bin\java.exe -javaagent:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\lib\idea_rt.jar=55707:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\bin -Dfile.encoding=UTF-8 -classpath C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\charsets.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\access-bridge-64.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\cldrdata.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\dnsns.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\jaccess.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\localedata.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\nashorn.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunec.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunjce_provider.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunmscapi.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\sunpkcs11.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\ext\zipfs.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\jce.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\jfr.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\jsse.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\management-agent.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\resources.jar;C:\Users\cleme\java\jdks\jdk-8-312\jre\lib\rt.jar;C:\Users\cleme\git\cquoss\jboss-serialization-bug\target\classes;C:\Users\cleme\.m2\repository\de\quoss\jboss\jboss-serialization\1.0-SNAPSHOT\jboss-serialization-1.0-SNAPSHOT.jar;C:\Users\cleme\.m2\repository\trove\trove\1.0.2\trove-1.0.2.jar;C:\Users\cleme\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-classic\1.2.11\logback-classic-1.2.11.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-core\1.2.11\logback-core-1.2.11.jar;C:\Users\cleme\.m2\repository\org\slf4j\log4j-over-slf4j\1.7.36\log4j-over-slf4j-1.7.36.jar de.quoss.bug.jboss.serialization.Main
07:59:44.872 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
07:59:44.874 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for readResolve
07:59:44.874 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
07:59:44.874 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for writeReplace
07:59:44.874 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
07:59:44.878 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
07:59:44.878 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.InvocationHandler$h = 3757213363974229139
07:59:44.879 [main] DEBUG org.jboss.serial.classmetamodel.FieldsManager - FieldsManager in use = org.jboss.serial.classmetamodel.UnsafeFieldsManager
07:59:44.880 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject for class=java.util.Hashtable
07:59:44.880 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
07:59:44.880 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
07:59:44.880 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
07:59:44.880 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
07:59:44.880 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
07:59:44.880 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
07:59:44.880 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
07:59:44.880 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
07:59:44.880 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
07:59:44.881 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
07:59:44.881 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject::a new reference 1
07:59:44.884 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite::java.util.Hashtable contains 1 slots
07:59:44.884 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite:: slot 0 NR=java.util.Hashtable from parentClass=java.util.Hashtable
07:59:44.884 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithMethod slot=java.util.Hashtable
07:59:44.885 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable and 2 fields
07:59:44.885 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=0
07:59:44.885 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField threshold with object=NULL
07:59:44.885 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=1
07:59:44.885 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField loadFactor with object=NULL
07:59:44.885 [main] INFO de.quoss.bug.jboss.serialization.Main - [buf.length=82,buf.hashCode=236820913]
07:59:44.911 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - objectFromDescription::reading new definition
07:59:44.911 [main] DEBUG org.jboss.serial.util.StringUtil - Reading string with utfSize=19 isLong=false
07:59:44.911 [main] DEBUG org.jboss.serial.util.StringUtil - readString::pulling data to Buffer at pos 0 size= 0
07:59:44.912 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
07:59:44.912 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
07:59:44.912 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
07:59:44.912 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
07:59:44.912 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
07:59:44.912 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
07:59:44.912 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
07:59:44.912 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
07:59:44.912 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
07:59:44.912 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
07:59:44.912 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - Reading object for id=1 classLoader=sun.misc.Launcher$AppClassLoader@18b4aac2 className = java.util.Hashtable
07:59:44.912 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::class java.util.Hashtable contains 1 slots
07:59:44.912 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::slot[0]=java.util.Hashtable
07:59:44.912 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - readSlotWithMethod slot=java.util.Hashtable
07:59:44.913 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - readSlotWithFields slot=java.util.Hashtable
07:59:44.913 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - FieldName on Read=threshold
07:59:44.913 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - FieldName on Read=loadFactor
07:59:44.913 [main] INFO de.quoss.bug.jboss.serialization.Main - [deserialized={},deserialized.class.name=java.util.Hashtable

Process finished with exit code 0
```

And running with jdk8u322:

```
C:\Users\cleme\java\jdks\jdk-8\bin\java.exe -javaagent:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\lib\idea_rt.jar=57186:C:\Users\cleme\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\221.5080.210\bin -Dfile.encoding=UTF-8 -classpath C:\Users\cleme\java\jdks\jdk-8\jre\lib\charsets.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\access-bridge-64.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\cldrdata.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\dnsns.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\jaccess.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\localedata.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\nashorn.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunec.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunjce_provider.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunmscapi.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\sunpkcs11.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\ext\zipfs.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\jce.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\jfr.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\jsse.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\management-agent.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\resources.jar;C:\Users\cleme\java\jdks\jdk-8\jre\lib\rt.jar;C:\Users\cleme\git\cquoss\jboss-serialization-bug\target\classes;C:\Users\cleme\.m2\repository\de\quoss\jboss\jboss-serialization\1.0-SNAPSHOT\jboss-serialization-1.0-SNAPSHOT.jar;C:\Users\cleme\.m2\repository\trove\trove\1.0.2\trove-1.0.2.jar;C:\Users\cleme\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-classic\1.2.11\logback-classic-1.2.11.jar;C:\Users\cleme\.m2\repository\ch\qos\logback\logback-core\1.2.11\logback-core-1.2.11.jar;C:\Users\cleme\.m2\repository\org\slf4j\log4j-over-slf4j\1.7.36\log4j-over-slf4j-1.7.36.jar de.quoss.bug.jboss.serialization.Main
08:01:54.510 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
08:01:54.512 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for readResolve
08:01:54.512 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
08:01:54.512 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.lang.reflect.Proxy looking for writeReplace
08:01:54.512 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.lang.reflect.Proxy
08:01:54.515 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.Proxy = -1281934524198291041
08:01:54.515 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.lang.reflect.InvocationHandler$h = 3757213363974229139
08:01:54.516 [main] DEBUG org.jboss.serial.classmetamodel.FieldsManager - FieldsManager in use = org.jboss.serial.classmetamodel.UnsafeFieldsManager
08:01:54.517 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject for class=java.util.Hashtable
08:01:54.517 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
08:01:54.517 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
08:01:54.517 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
08:01:54.517 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
08:01:54.517 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
08:01:54.517 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
08:01:54.517 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
08:01:54.518 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
08:01:54.518 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
08:01:54.518 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
08:01:54.518 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - describeObject::a new reference 1
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite::java.util.Hashtable contains 1 slots
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultWrite:: slot 0 NR=java.util.Hashtable from parentClass=java.util.Hashtable
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithMethod slot=java.util.Hashtable
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable and 2 fields
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=0
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField threshold with object=NULL
08:01:54.521 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields FieldNr=1
08:01:54.522 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - writeSlotWithFields slot=java.util.Hashtable primitiveField loadFactor with object=NULL
08:01:54.522 [main] INFO de.quoss.bug.jboss.serialization.Main - [buf.length=82,buf.hashCode=236820913]
08:01:54.553 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - objectFromDescription::reading new definition
08:01:54.553 [main] DEBUG org.jboss.serial.util.StringUtil - Reading string with utfSize=19 isLong=false
08:01:54.553 [main] DEBUG org.jboss.serial.util.StringUtil - readString::pulling data to Buffer at pos 0 size= 0
08:01:54.553 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
08:01:54.553 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for readResolve
08:01:54.553 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
08:01:54.553 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
08:01:54.553 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::class=java.util.Hashtable looking for writeReplace
08:01:54.553 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Hashtable
08:01:54.553 [main] DEBUG org.jboss.serial.classmetamodel.ClassMetaData - lookupMethodOnHierarchy::currentClass=class java.util.Dictionary
08:01:54.553 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field java.util.Hashtable = 8568335707554902210
08:01:54.553 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field int$threshold = -81821300837738335
08:01:54.554 [main] DEBUG org.jboss.serial.util.HashStringUtil - hash on field float$loadFactor = 308335647531269238
08:01:54.554 [main] DEBUG org.jboss.serial.objectmetamodel.ObjectDescriptorFactory - Reading object for id=1 classLoader=sun.misc.Launcher$AppClassLoader@18b4aac2 className = java.util.Hashtable
08:01:54.554 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::class java.util.Hashtable contains 1 slots
08:01:54.554 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - defaultRead::slot[0]=java.util.Hashtable
08:01:54.554 [main] DEBUG org.jboss.serial.persister.RegularObjectPersister - readSlotWithMethod slot=java.util.Hashtable
08:01:54.555 [main] DEBUG org.jboss.serial.util.StringUtil - Reading string with utfSize=4611686018427390720 isLong=true
08:01:54.555 [main] DEBUG org.jboss.serial.util.StringUtil - readString::pulling data to Buffer at pos 0 size= 0
Exception in thread "main" java.io.IOException
	at org.jboss.serial.persister.RegularObjectPersister.readSlotWithMethod(RegularObjectPersister.java:107)
	at org.jboss.serial.persister.RegularObjectPersister.defaultRead(RegularObjectPersister.java:269)
	at org.jboss.serial.persister.RegularObjectPersister.readData(RegularObjectPersister.java:241)
	at org.jboss.serial.objectmetamodel.ObjectDescriptorFactory.readObjectDescriptionFromStreaming(ObjectDescriptorFactory.java:412)
	at org.jboss.serial.objectmetamodel.ObjectDescriptorFactory.objectFromDescription(ObjectDescriptorFactory.java:82)
	at org.jboss.serial.objectmetamodel.DataContainer$DataContainerDirectInput.readObject(DataContainer.java:643)
	at org.jboss.serial.io.JBossObjectInputStream.readObjectOverride(JBossObjectInputStream.java:163)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:494)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:461)
	at de.quoss.bug.jboss.serialization.Main.run(Main.java:30)
	at de.quoss.bug.jboss.serialization.Main.main(Main.java:35)
Caused by: java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.jboss.serial.persister.RegularObjectPersister.readSlotWithMethod(RegularObjectPersister.java:103)
	... 10 more
Caused by: java.io.EOFException
	at java.io.DataInputStream.readFully(DataInputStream.java:197)
	at org.jboss.serial.util.StringUtil.pullDataToBuffer(StringUtil.java:191)
	at org.jboss.serial.util.StringUtil.readString(StringUtil.java:238)
	at org.jboss.serial.objectmetamodel.DataContainer$DataContainerDirectInput.readUTF(DataContainer.java:757)
	at org.jboss.serial.persister.ObjectInputStreamProxy.readUTF(ObjectInputStreamProxy.java:196)
	at org.jboss.serial.objectmetamodel.FieldsContainer.readField(FieldsContainer.java:147)
	at org.jboss.serial.objectmetamodel.FieldsContainer.readMyself(FieldsContainer.java:218)
	at org.jboss.serial.persister.ObjectInputStreamProxy.readFields(ObjectInputStreamProxy.java:224)
	at java.util.Hashtable.readObject(Hashtable.java:1170)
	... 15 more

Process finished with exit code 1
```
Update 05/01/2022, 1.17pm:

This [commit](https://github.com/openjdk/jdk8u/commit/a90219cc90ba499b731fa1c00304919f8b0493b5) is responsible for this bug. After this change jboss-serialization is simply not compatible with the jdk implementation of java.util.Hashtable any more.

Instead of fixing jboss-serialization i think best would be to get rid of jboss-serialization in jboss-cache.

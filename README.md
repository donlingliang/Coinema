
# Coinema

## Table of Contents

* <a name="commit-project-setup-sub"></a>[Android Project Setup](#commit-project-setup)
* <a name="commit-retrofit2-sub"></a>[Retrofit 2 Setup](#commit-retrofit2)
* <a name="commit-moshi-sub"></a>[Moshi Json library and Kotlin miscs](#commit-moshi)
* <a name="commit-recyclerview-sub"></a>[RecyclerView & AndroidX migration](#commit-recyclerview)

### <a name="commit-project-setup"></a>[Android Project Setup](https://github.com/donlingliang/Coinema/commit/ac266ad29979b60507374fd98650348a2ada0636)<sup>	[Back ⇈](#ccommit-project-setup-sub)</sup>

This is a pretty straight-forward setup for a new Android project with a bunch of build.gradle script modification.
Make sure the **permissions** are added in the AndroidManifest.xml

### <a name="commit-retrofit2"></a>[Retrofit 2 Setup](https://github.com/donlingliang/Coinema/commit/966af5874c67201d99842b99260126f18a391e69)<sup>	[Back ⇈](#commit-retrofit2-sub)</sup>

 We	are consuming a [TMDB](https://developers.themoviedb.org/3/getting-started/introduction) **Get** [popular endpoint](https://developers.themoviedb.org/3/movies/get-popular-movies) which will give us a response if our request is correct. The request url is shown below:
```
https://api.themoviedb.org/3/movie/popular?api_key={api_key}
```
- Define API interfaces and DataModels
- Build a Retrofit instance and a OkHttp3 client for requests
- Build Interceptors for Authentication & other purpose
- Asynchronous network request and callback execution

### <a name="commit-moshi"></a>[Moshi Json library and Kotlin miscs](https://github.com/donlingliang/Coinema/commit/966af5874c67201d99842b99260126f18a391e69)<sup>	[Back ⇈](#commit-moshi-sub)</sup>
Moshi/Gson/Jackson are Json (de)serialize library, we can pick the one that aids us to get jobs done faster.

### <a name="commit-recyclerview"></a>[RecyclerView & AndroidX migration](https://github.com/donlingliang/Coinema/commit/c26c269f49f888206fb0008595f333c5a6da6103)<sup>	[Back ⇈](#commit-recyclerview-sub)</sup>
 - RecyclerView dependency setup & LayoutManger
 - RecyclerView.Adapter
 - ViewHolder design with Coil for image loading

> Written with [StackEdit](https://stackedit.io/).

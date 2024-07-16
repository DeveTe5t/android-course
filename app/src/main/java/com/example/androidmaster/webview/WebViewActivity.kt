package com.example.androidmaster.webview

import android.app.DownloadManager
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.WebResourceRequest
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R

import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
//import android.widget.TextView
import android.widget.Toast

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //lateinit var textView: TextView
        var progressBar: ProgressBar? = null

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //textView = findViewById(R.id.textView)
        progressBar = findViewById<ProgressBar>(R.id.progress_Bar) as ProgressBar
        //textView.text = "===> HEYA <==="
        // Find the WebView by its id
        val webView: WebView = findViewById(R.id.webView)

        // Load a web page
        val url = "https://univim.edu.mx/campus/"
        //val url = "https://univim.edu.mx/convocatorias"
        webView.loadUrl(url)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)

        webView.webViewClient = object : WebViewClient() {
            // val progressDialog: ProgressDialog? = ProgressDialog(Context)
            // progressBar = findViewById<ProgressBar>(R.id.progress_Bar) as ProgressBar

            //val progressBar: ProgressBar = ProgressBar(this@WebViewActivity)

            /*override fun onProgressChanged(view: WebView, newProgress: Int) {
                textView.text = "Page loading : $newProgress%"
                if (newProgress == 100) {
                    textView.text = "Page Loaded."
                }
            }*/

            //override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            override fun onPageStarted(view: WebView?, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE

                //textView.text = "onPageStarted url: $url"
                println("Start url: $url")
                //textView.text = "Page starting"
                // if ( (url.contains("/mod/resource/") && url.endsWith("forceview=1")) || url.endsWith(".pdf")) {
                // if (url.endsWith(".pdf")) {
                //    downloadFile(url)
                //}

            }

            // override fun onPageFinished(view: WebView?, url: String?) {
            override fun onPageFinished(view: WebView?, url: String) {
                super.onPageFinished(view, url)
                //textView.text = "onPageFinished url: $url"
                println("Finish url: $url")
                //textView.text = "Page completed"
                // if ( (url.contains("/mod/resource/") && url.endsWith("forceview=1")) || url.endsWith(".pdf")) {
                //if (url.endsWith(".pdf")) {
                //    downloadFile(url)
                //    Toast.makeText(this@WebViewActivity, "Page load completed", Toast.LENGTH_LONG).show()
                //}
                progressBar.visibility = View.INVISIBLE
            }
            // override fun onPageFinished(view: WebView, weburl: String) {
            /*Toast.makeText(
                this, "Your WebView is Loaded....",
                Toast.LENGTH_LONG
            ).show()*/
            // textView.text = "Page completed"
            // }

            /*override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.url?.let { url ->
                    if (url.endsWith(".pdf")) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                        //Toast.makeText(this@WebViewActivity, "Page load completed", Toast.LENGTH_LONG).show()
                        return true
                    }
                }

                return super.shouldOverrideUrlLoading(view, request)
            }*/
        }
    }

    private fun downloadFile(url: String) {

        val fileName = url.split("/").last()
        val request = DownloadManager.Request(Uri.parse(url))
            // .setTitle("File")
            .setDescription("Downloading...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            // .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "filename_to_save")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
            .setAllowedOverMetered(true) // all over metered internet connection

        val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager // get downlod system service
        dm.enqueue(request) // set our request
    }
}

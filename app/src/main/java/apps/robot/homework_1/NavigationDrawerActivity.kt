package apps.robot.homework_1

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, EditDialogFragment.OnEditedListener {
    override fun onEdit(login: String, email: String) {
        val profileFragment = supportFragmentManager.findFragmentByTag(ProfileFragment.toString()) as ProfileFragment
        profileFragment.updateLoginEmail(login, email)

        val tvHeaderLogin = findViewById<TextView>(R.id.tv_header_login)
        val tvHeaderEmail = findViewById<TextView>(R.id.tv_header_email)

        tvHeaderLogin.text = login
        tvHeaderEmail.text = email
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val ft = supportFragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.nav_favorites -> {
                ft.replace(R.id.fragment_placeholder, FavoritesFragment.newInstance())
            }
            R.id.nav_messages -> {
                ft.replace(R.id.fragment_placeholder, MessageFragment.newInstance())
            }
            R.id.nav_profile -> {
                ft.replace(R.id.fragment_placeholder, ProfileFragment.newInstance(), ProfileFragment.toString())
            }
        }
        ft.addToBackStack(null)
        ft.commit()

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}

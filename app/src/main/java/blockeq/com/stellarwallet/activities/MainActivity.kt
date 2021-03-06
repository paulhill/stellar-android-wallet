package blockeq.com.stellarwallet.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import blockeq.com.stellarwallet.R
import blockeq.com.stellarwallet.fragments.ReceiveFragment
import blockeq.com.stellarwallet.fragments.SettingsFragment
import blockeq.com.stellarwallet.fragments.TradingFragment
import blockeq.com.stellarwallet.fragments.WalletFragment
import blockeq.com.stellarwallet.helpers.disableShiftMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.disableShiftMode()
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.selectedItemId = R.id.nav_wallet
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_wallet -> {
                val walletFragment = WalletFragment.newInstance()
                openFragment(walletFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_trading -> {
                val tradingFragment = TradingFragment.newInstance()
                openFragment(tradingFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_receive -> {
                val receiveFragment = ReceiveFragment.newInstance()
                openFragment(receiveFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_settings -> {
                val settingsFragment = SettingsFragment.newInstance()
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
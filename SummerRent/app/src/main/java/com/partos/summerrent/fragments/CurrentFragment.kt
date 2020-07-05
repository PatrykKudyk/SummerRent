package com.partos.summerrent.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.partos.summerrent.MyApp
import com.partos.summerrent.R
import com.partos.summerrent.db.DataBaseHelper
import com.partos.summerrent.pager.CurrentRentsViewPagedAdapter
import com.partos.summerrent.pager.PastRentsViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_current.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CurrentFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var viewPager: ViewPager
    private lateinit var editButton: Button
    private lateinit var saveButton: Button
    private lateinit var editLayout: LinearLayout
    private lateinit var colorsLayout: LinearLayout
    private lateinit var greenButton: Button
    private lateinit var orangeButton: Button
    private lateinit var redButton: Button
    private lateinit var greenOrangeButton: Button
    private lateinit var orangeGreenButton: Button
    private lateinit var redGreenButton: Button
    private lateinit var greenRedButton: Button
    private lateinit var orangeRedButton: Button
    private lateinit var redOrangeButton: Button
    private lateinit var blackButton: Button
    private lateinit var saveImage: ImageView
    private lateinit var closeImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_current, container, false);
        initFragment()
        return rootView
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CurrentFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun initFragment() {
        assignViews()
        viewPager.adapter = CurrentRentsViewPagedAdapter(rootView.context)
        editButton.setOnClickListener {
            editLayout.visibility = View.GONE
            colorsLayout.visibility =  View.VISIBLE
            MyApp.isEditing = true
        }
        saveButton.setOnClickListener {
            colorsLayout.visibility = View.GONE
            editLayout.visibility = View.VISIBLE
            MyApp.isEditing = false
            MyApp.color = -1
        }
        blackButton.setOnClickListener {
            MyApp.color = 0
        }
        greenButton.setOnClickListener {
            MyApp.color = 1
        }
        orangeButton.setOnClickListener {
            MyApp.color = 2
        }
        redButton.setOnClickListener {
            MyApp.color = 3
        }
        greenOrangeButton.setOnClickListener {
            MyApp.color = 4
        }
        orangeGreenButton.setOnClickListener {
            MyApp.color = 5
        }
        redGreenButton.setOnClickListener {
            MyApp.color = 6
        }
        greenRedButton.setOnClickListener {
            MyApp.color = 7
        }
        orangeRedButton.setOnClickListener {
            MyApp.color = 8
        }
        redOrangeButton.setOnClickListener {
            MyApp.color = 9
        }
        saveImage.setOnClickListener {
            hideKeyboard()
        }
        closeImage.setOnClickListener {
            current_card_view.visibility = View.GONE
            hideKeyboard()
        }
    }

    private fun assignViews() {
        viewPager = rootView.findViewById(R.id.current_view_pager)
        editButton = rootView.findViewById(R.id.current_button_edit)
        saveButton = rootView.findViewById(R.id.current_colors_save)
        editLayout = rootView.findViewById(R.id.current_layout_edit)
        colorsLayout = rootView.findViewById(R.id.current_layout_colors)
        greenButton = rootView.findViewById(R.id.current_colors_green)
        orangeButton = rootView.findViewById(R.id.current_colors_orange)
        redButton = rootView.findViewById(R.id.current_colors_red)
        greenOrangeButton = rootView.findViewById(R.id.current_colors_green_orange)
        orangeGreenButton = rootView.findViewById(R.id.current_colors_orange_green)
        redGreenButton = rootView.findViewById(R.id.current_colors_red_green)
        greenRedButton = rootView.findViewById(R.id.current_colors_green_red)
        orangeRedButton = rootView.findViewById(R.id.current_colors_orange_red)
        redOrangeButton = rootView.findViewById(R.id.current_colors_red_orange)
        blackButton = rootView.findViewById(R.id.current_colors_black)
        saveImage = rootView.findViewById(R.id.current_note_save)
        closeImage = rootView.findViewById(R.id.current_note_close)
    }

    private fun hideKeyboard() {
        val view = activity?.currentFocus
        if (view != null) {
            val inputManager =
                rootView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
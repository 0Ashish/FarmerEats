package com.example.farmereats.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentSignUpHoursBinding


class SignUpHours : Fragment() {
    private lateinit var binding : FragmentSignUpHoursBinding
    private lateinit var dayButtons: List<Button>
    private lateinit var timeSlotButtons: List<Button>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        continue to verification2
        binding.continueToVerification2.setOnClickListener {
            findNavController().navigate(R.id.action_signUpHours_to_signUpVerification2)
        }
//        back to verification
        binding.backToVerification.setOnClickListener{
            findNavController().navigate(R.id.action_signUpHours_to_signUpVerification)
        }
        // Initialize day buttons
        dayButtons = listOf(
            view.findViewById(R.id.btnMon),
            view.findViewById(R.id.btnTue),
            view.findViewById(R.id.btnWed),
            view.findViewById(R.id.btnThu),
            view.findViewById(R.id.btnFri),
            view.findViewById(R.id.btnSat),
            view.findViewById(R.id.btnSun)
        )

        // Initialize time slot buttons
        timeSlotButtons = listOf(
            view.findViewById(R.id.btnTime1),
            view.findViewById(R.id.btnTime2),
            view.findViewById(R.id.btnTime3),
            view.findViewById(R.id.btnTime4),
            view.findViewById(R.id.btnTime5)
        )

        // Set click listeners for day buttons
        dayButtons.forEach { button ->
            button.setOnClickListener {
                updateDaySelection(button)
            }
        }

        // Set click listeners for time slot buttons
        timeSlotButtons.forEach { button ->
            button.setOnClickListener {
                toggleTimeSlotSelection(button)
            }
        }
    }

    // Function to update day selection
    private fun updateDaySelection(selectedButton: Button) {
        dayButtons.forEach { button ->
            button.isSelected = button == selectedButton
        }
    }

    // Function to toggle time slot selection
    private fun toggleTimeSlotSelection(button: Button) {
        button.isSelected = !button.isSelected
    }
}

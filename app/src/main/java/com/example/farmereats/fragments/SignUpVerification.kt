package com.example.farmereats.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.farmereats.R
import com.example.farmereats.databinding.FragmentSignUpVerificationBinding

class SignUpVerification : Fragment() {
    private lateinit var binding: FragmentSignUpVerificationBinding
    private lateinit var filePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpVerificationBinding.inflate(inflater, container, false)

        // Set up file picker launcher
        filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val selectedFileUri: Uri? = data?.data
                selectedFileUri?.let { uri ->
                    handleFileSelection(uri)
                }
            }
        }

        // Make ImageView clickable and set click listener to open the file picker
        binding.dropImage.setOnClickListener {
            openFilePicker()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.continueToHoursPage.setOnClickListener {
            findNavController().navigate(R.id.action_signUpVerification_to_signUpHours)
        }
        binding.backToFarmInfo.setOnClickListener {
            findNavController().navigate(R.id.action_signUpVerification_to_signUpFarmInfo)
        }
    }

    // Function to open the file picker
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            type = "*/*"
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/*", "application/pdf"))
        }
        filePickerLauncher.launch(intent)
    }

    // Handle the file selection and show file details
    private fun handleFileSelection(uri: Uri) {
        val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            // Ensure the column exists before accessing it
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1) {
                if (it.moveToFirst()) {
                    val displayName = it.getString(nameIndex)
                    Toast.makeText(requireContext(), "File selected: $displayName", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Handle case where DISPLAY_NAME column is not available
                Toast.makeText(requireContext(), "Unable to retrieve file name", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

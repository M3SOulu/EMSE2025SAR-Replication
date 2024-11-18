# Let's refine the cleaning process by ensuring that lines that belong together are joined correctly.
# We will check for lines that end with ";" and join them appropriately.
import sys
file_path = sys.argv[1]

# Read the file content
with open(file_path, 'r') as file:
    content = file.read()

# Split the content into lines
lines = content.split('\n')

# Rebuild the content by joining lines appropriately
cleaned_lines = []
current_line = ''

for line in lines:
    stripped_line = line.strip()
    if stripped_line:
        current_line += stripped_line
        if stripped_line.endswith(';'):
            cleaned_lines.append(current_line)
            current_line = ''
        else:
            current_line += ' '

# Join the cleaned lines into the final content
final_cleaned_content = '\n'.join(cleaned_lines)

# Write the final cleaned content back to a new file
final_cleaned_file_path = 'cleaned_memgraph.cypherl'

with open(final_cleaned_file_path, 'w') as file:
    file.write(final_cleaned_content)
